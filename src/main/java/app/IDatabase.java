package app;

import java.util.*;
import exceptions.DBException;
import sql.SQLTerm;

public interface IDatabase {
                public void init();

                public void createTable(String strTableName, String strClusteringKeyColumn,
                                                Hashtable<String, String> htblColNameType,
                                                Hashtable<String, String> htblColNameMin,
                                                Hashtable<String, String> htblColNameMax) throws DBException;

                public void createIndex(String strTableName, String[] strarrColName) throws DBException;

                public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
                                                throws DBException;

                public void updateTable(String strTableName, String strClusteringKeyValue,
                                                Hashtable<String, Object> htblColNameValue) throws DBException;

                public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue)
                                                throws DBException;

                // public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[]
                // strarrOperators) throws DBException;

}
