package app;

import entities.Car;
import entities.ComputedData;
import interfaces.ComputingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * Created by Vlad on 12-Nov-17.
 */
@Controller
@RequestMapping(value = "/index")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    public String showForm() {
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void processForm(HttpServletRequest request, HttpServletResponse response) {
        Car car = new Car();
        car.setEngineSize(Integer.parseInt(request.getParameter("engSize")));
        car.setPrice(Double.parseDouble(request.getParameter("price")));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        try{
            Registry registry = LocateRegistry.getRegistry();

            ComputingService stub = (ComputingService) registry.lookup("compute");

            ComputedData result;

            result = stub.computeData(car);

            response.getWriter().println("Tax: " + result.getTax() + " \nSelling price: " + result.getSellingPrice());

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
