package service;

import dao.RelationDAO;
import entyties.Relation;
import util.TriState;

public class RelationService {

    public TriState ifRelationExist(int producentStationId, int customerStationId) {

        try {
            if(new RelationDAO().getRelationIfExist(producentStationId,customerStationId))
                return TriState.triStateTrue;
            else
                return TriState.triStateFalse;
        }
        catch (Exception e) {
            return TriState.triStateError;
        }

    }

    public Relation getRelation(int producentStationId, int customerStationId) {

        Relation relation = null;
        try {
            relation = new RelationDAO().getRelation(producentStationId,customerStationId);
                return relation;

        }
        catch (Exception e) {
            return relation;
        }
    }

    public  Boolean saveRelation(Relation relation) {
        Boolean saved = false;
        try {
            new RelationDAO().saveRelation(relation);
            saved = true;
            return saved;
        }
        catch (Exception e) {
            return saved;
        }
    }


    public  Boolean updateRelation(Relation relation) {

        try {
            new RelationDAO().updateRelation(relation);
            return true;
        }
        catch (Exception e) {
            return false;
        }


    }
}
