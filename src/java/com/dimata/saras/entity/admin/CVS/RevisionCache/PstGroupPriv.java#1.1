/*
 * PstGroupPriv.java
 *
 * Created on April 3, 2002, 9:29 AM
 */

package com.dimata.saras.entity.admin;

/**
 *
 * @author  ktanjana
 * @version
 */

import java.util.*;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.qdep.db.I_DBInterface;
import com.dimata.qdep.db.I_DBType;
import com.dimata.qdep.entity.*;

public class PstGroupPriv extends DBHandler implements I_DBInterface, I_DBType, I_Persintent {

    //public static final String TBL_GROUP_PRIV = "GROUP_PRIV";
    public static final String TBL_GROUP_PRIV = "saras_group_priv";
    public static final int FLD_GROUP_ID = 0;
    public static final int FLD_PRIV_ID = 1;

    public static final String[] fieldNames = {
        "GROUP_ID", "PRIV_ID"
    };

    public static int[] fieldTypes = {
        TYPE_PK + TYPE_FK + TYPE_LONG,
        TYPE_PK + TYPE_FK + TYPE_LONG
    };


    /** Creates new PstGroupPriv */
    public PstGroupPriv() {
    }

    public PstGroupPriv(int i) throws DBException {
        super(new PstGroupPriv());
    }


    public PstGroupPriv(String sOid) throws DBException {
        super(new PstGroupPriv(0));
        if (!locate(sOid))
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        else
            return;
    }


    public PstGroupPriv(long groupOID, long privOID) throws DBException {
        super(new PstGroupPriv(0));

        if (!locate(groupOID, privOID))
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        else
            return;

    }


    /**
     *	Implemanting I_Entity interface methods
     */
    public int getFieldSize() {
        return fieldNames.length;
    }

    public String getTableName() {
        return TBL_GROUP_PRIV;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstGroupPriv().getClass().getName();
    }


    /**
     *	Implementing I_DBInterface interface methods
     */
    public long fetch(Entity ent) {
        GroupPriv entObj = PstGroupPriv.fetch(ent.getOID(0), ent.getOID(1));
        ent = (Entity) entObj;
        return entObj.getOID();
    }


    public long insert(Entity ent) {
        return PstGroupPriv.insert((GroupPriv) ent);
    }

    public long update(Entity ent) {
        return update((GroupPriv) ent);
    }

    public long delete(Entity ent) {
        return delete((GroupPriv) ent);
    }


    public static GroupPriv fetch(long groupID, long privID) {
        GroupPriv entObj = new GroupPriv();
        try {
            PstGroupPriv pstObj = new PstGroupPriv(groupID, privID);
            entObj.setGroupID(groupID);
            entObj.setPrivID(privID);
        } catch (DBException e) {
            System.out.println(e);
        }
        return entObj;
    }


    public static long insert(GroupPriv entObj) {
        try {
            PstGroupPriv pstObj = new PstGroupPriv(0);

            System.out.println("GroupID : " + entObj.getGroupID());
            System.out.println("POID : " + entObj.getPrivID());

            pstObj.setLong(FLD_GROUP_ID, entObj.getGroupID());
            pstObj.setLong(FLD_PRIV_ID, entObj.getPrivID());

            pstObj.insert();
            return entObj.getGroupID();
        } catch (DBException e) {
            System.out.println(e);
        }
        return 0;
    }


    public static long deleteByGroup(long oid) {
        PstGroupPriv pstObj = new PstGroupPriv();
        DBResultSet dbrs = null;
        try {
            String sql = "DELETE FROM " + pstObj.getTableName() +
                    " WHERE " + PstGroupPriv.fieldNames[PstGroupPriv.FLD_GROUP_ID] +
                    " = '" + oid + "'";

            DBHandler.execUpdate(sql);
            return oid;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }

        return 0;
    }

    public static long deleteByPriv(long oid) {
        PstGroupPriv pstObj = new PstGroupPriv();
        DBResultSet dbrs = null;
        try {
            String sql = "DELETE FROM " + pstObj.getTableName() +
                    " WHERE " + PstGroupPriv.fieldNames[PstGroupPriv.FLD_PRIV_ID] +
                    " = '" + oid + "'";
            System.out.println(sql);
            DBHandler.execUpdate(sql);
            return oid;
        } catch (Exception e) {
            System.out.println(" PstGroupPriv.deleteByPriv " + e);
        } finally {
            DBResultSet.close(dbrs);
        }

        return 0;
    }


    public static long update(GroupPriv entObj) {
        if (entObj != null && entObj.getGroupID() != 0) {
            try {
                PstGroupPriv pstObj = new PstGroupPriv(entObj.getGroupID(), entObj.getPrivID());

                pstObj.update();
                return entObj.getGroupID();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return 0;
    }


    public static Vector listAll() {
        return list(0, 0, null, null);
    }


    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        return new Vector();
    }

}
