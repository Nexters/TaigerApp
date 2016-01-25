package com.nexters.taigerapp.network.response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ResponseBodyArray {
    private final JSONArray jsonArray;
    private final int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public ResponseBodyArray(int statusCode, byte[] body) throws ResponseBody.ResponseBodyException {
        this.statusCode = statusCode;
        if (body == null) {
            throw new ResponseBody.ResponseBodyException();
        }

        try {
            this.jsonArray = new JSONArray(new String(body));
        } catch (JSONException e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }

    public ResponseBodyArray(int statusCode, JSONArray jsonArray) throws ResponseBody.ResponseBodyException {
        this.statusCode = statusCode;
        if (jsonArray == null) {
            throw new ResponseBody.ResponseBodyException();
        }
        this.jsonArray = jsonArray;
    }
    public int length() {
        return jsonArray.length();
    }
    public long getLong(int i) throws ResponseBody.ResponseBodyException {
        try {
            Object obj = getOrThrow(i);
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            else if (obj instanceof Long) {
                return (Long) obj;
            }
            else {
                throw new ResponseBody.ResponseBodyException();
            }
        }
        catch(Exception e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }
    public ResponseBody getBody(int i) throws ResponseBody.ResponseBodyException {
        try {
            return new ResponseBody(getStatusCode(), (JSONObject) getOrThrow(i));
        }
        catch(ResponseBody.ResponseBodyException e) {
            throw e;
        }
        catch(Exception e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }
    public String getString(int i) throws ResponseBody.ResponseBodyException {
        try {
            return (String) getOrThrow(i);
        }
        catch(Exception e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }

    public int getInt(int i) throws ResponseBody.ResponseBodyException {
        try {
            return (Integer) getOrThrow(i);
        }
        catch(Exception e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }

    public Boolean getBoolean(int i) throws ResponseBody.ResponseBodyException {
        try {
            return (Boolean) getOrThrow(i);
        }
        catch(Exception e) {
            throw new ResponseBody.ResponseBodyException(e);
        }
    }

    private Object getOrThrow(int index) {
        Object v = null;
        try {
            v = jsonArray.get(index);
        } catch (JSONException ignore) {
        }

        if (v == null) {
            throw new NoSuchElementException();
        }
        return v;
    }

    public <F, T> List<T> getConvertedList(ArrayConverter<F, T> converter) throws ResponseBody.ResponseBodyException {
        if (jsonArray.length() > 0) {
            List<T> list = new ArrayList<T>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(converter.convert(converter.fromArray(jsonArray, i)));
            }
            return list;
        }
        return Collections.emptyList();
    }

    public <F, T> List<T> optConvertedList(ArrayConverter<F, T> converter, List<T> def) throws ResponseBody.ResponseBodyException {
        try {
            return getConvertedList(converter);
        } catch (Exception e) {

        }
        return def;
    }

    @Override
    public String toString() {
        return jsonArray.toString();
    }

    public interface ArrayConverter<F, T> {
        F fromArray(JSONArray array, int i) throws ResponseBody.ResponseBodyException;
        T convert(F o) throws ResponseBody.ResponseBodyException;
    }

    public abstract static class PrimitiveConverter<T> implements ArrayConverter<T, T> {
        @Override
        public final T convert(T o) throws ResponseBody.ResponseBodyException {
            return o;
        }
    }

    public static final PrimitiveConverter<String> STRING_CONVERTER = new PrimitiveConverter<String>() {
        @Override
        public String fromArray(JSONArray array, int i) throws ResponseBody.ResponseBodyException {
            try {
                return array.getString(i);
            } catch (JSONException e) {
                throw new ResponseBody.ResponseBodyException(e);
            }
        }
    };

    public static <T> List<T> toList(ResponseBodyArray array) throws ResponseBody.ResponseBodyException {
        List<T> list = new ArrayList<T>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.getOrThrow(i);
            if(value instanceof JSONArray) {
                value = toList(new ResponseBodyArray(array.getStatusCode(), (JSONArray) value));
            }

            else if(value instanceof JSONObject) {
                value = ResponseBody.toMap(new ResponseBody(array.getStatusCode(), (JSONObject) value));
            }
            list.add((T)value);
        }
        return list;
    }
}
