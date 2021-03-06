package net.javango.carcare.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;

public class CarListModel extends ViewModel {

    // Constant for logging
    private static final String TAG = CarListModel.class.getSimpleName();

    private LiveData<List<Car>> cars;

    // must be public
    public CarListModel() {
        AppDatabase database = AppDatabase.getDatabase();
        Log.d(TAG, "Retrieving cars from DATABASE!");
        cars = database.carDao().getAll();
    }

    public LiveData<List<Car>> getCars() {
        return cars;
    }

    public static CarListModel getInstance(Fragment fragment) {
        return ViewModelProviders.of(fragment).get(CarListModel.class);
    }

}
