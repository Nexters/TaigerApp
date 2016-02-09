package com.nexters.taigerapp.ui.departure;

public class DeparturePresenter {
    DepartureActivity departureActivity;
    DepartureInteractor departureInteractor;

    public DeparturePresenter(DepartureActivity departureActivity) {
        this.departureActivity = departureActivity;
        departureInteractor = new DepartureInteractor(departureActivity.getApplicationContext());
    }

    public void saveDeparture(Departure departure){
        departureInteractor.saveDeparture(departure);
    }

    public void saveUser(){
        departureInteractor.saveUser();
        departureActivity.showMeeting();
    }
}
