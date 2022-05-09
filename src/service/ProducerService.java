package service;

import dao.ProducerDAO;
import dao.ProducerStationsDAO;
import entyties.Producer;
import entyties.ProducerStation;
import entyties.Region;

import java.util.List;

public class ProducerService {


    public ProducerService(){

    }

    public Boolean saveProducer(Producer producer)  {
        try {
            new ProducerDAO().saveProducent(producer);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean saveProducerStation(ProducerStation producerStation)  {
        try {
            new ProducerStationsDAO().saveNewStation(producerStation);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public List<Producer> getProducersLikeString(String producerString)  {

        List<Producer> producers = null;

        try {
            producers = new ProducerDAO().getProducentAccordToString(producerString);
        }
        catch (Exception e) {

        }
        return  producers;
    }

    public  List<ProducerStation> getStationsFromProducer(int id) {

        List<ProducerStation> producerStations= null;

        try {
            producerStations = new ProducerStationsDAO().getAllProducerStationsForCertainProducer(id);
        }
        catch (Exception e) {

        }
        return  producerStations;
    }

    public List<Region> getAllRegions() {

        List<Region> regions = null;
        try {
            regions = new ProducerStationsDAO().getAllRegions();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  regions;
    }

    public Boolean updateProducerStation(ProducerStation producerStation)  {
        try {
            new ProducerStationsDAO().updateStation(producerStation);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
