import entities.Car;
import entities.ComputedData;
import interfaces.ComputingService;

import java.rmi.RemoteException;

/**
 * Created by Vlad on 13-Nov-17.
 */
public class ComputingServiceImpl implements ComputingService {

    @Override
    public ComputedData computeData(Car car) throws RemoteException {
        double tax, sum, sellingPrice;
        if(car.getEngineSize() <= 1600)
            sum = 8;
        else if (car.getEngineSize() > 1600 && car.getEngineSize() <= 2000)
            sum = 18;
        else if (car.getEngineSize() > 2000 && car.getEngineSize() <= 2600)
            sum = 72;
        else if (car.getEngineSize() > 2600 && car.getEngineSize() <= 3000)
            sum = 144;
        else
            sum = 290;
        tax = (car.getEngineSize() / 200) * sum;

        sellingPrice = car.getPrice() - (car.getPrice() / 7.0) * (2015 - car.getYear());

        ComputedData result = new ComputedData(tax,sellingPrice);
        return result;
    }
}
