package it.unisa.progettois.docapp.shared_DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public interface DAO<T> {
    Logger logger= Logger.getLogger(DAO.class.getName());
    List<T> doRetrieveByCondition(String condition) throws SQLException;
    List<T> doRetrieveByConditionWithLimit(String condition, int limit) throws SQLException;
    List<T> doRetrieveByConditionWithLimitAndOffset(String condition, int limit, int offset) throws SQLException;
    List<T> doRetrieveByHashMap(HashMap<String, String> hashmap) throws SQLException;
    List<T> doRetrieveAll() throws SQLException;
    List<T> doRetrieveAllWithLimit(int limit) throws SQLException;
    List<T> doRetrieveAllWithLimitAndOffset(int limit, int offset) throws SQLException;
    void doSave(T object) throws SQLException;
    List<T> doUpdate(String condition, T object) throws SQLException;
    boolean doDelete(String condition) throws SQLException;
    List<T> doSaveOrUpdate(T object) throws SQLException;
}
