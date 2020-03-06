package com.reedelk.database.commons;

import com.reedelk.runtime.api.message.content.ResultRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetConverter {

    public static ResultRow convertRow(JDBCRowMetadata metaData, ResultSet resultSetRow) throws SQLException {
        int columnCount = metaData.getColumnCount();
        List<Object> row = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            row.add(getObjectByColumnId(metaData, i, resultSetRow));
        }
        return new JDBCResultRow(metaData, row);
    }

    private static Object getObjectByColumnId(JDBCRowMetadata metaData, int columnId, ResultSet resultSetRow) throws SQLException {
        if (metaData.getColumnType(columnId) == java.sql.Types.ARRAY) {
            return resultSetRow.getArray(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.BIGINT) {
            return resultSetRow.getInt(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.BOOLEAN) {
            return resultSetRow.getBoolean(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.BLOB) {
            return resultSetRow.getBlob(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.DOUBLE) {
            return resultSetRow.getDouble(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.FLOAT) {
            return resultSetRow.getFloat(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.INTEGER) {
            return resultSetRow.getInt(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.NVARCHAR) {
            return resultSetRow.getNString(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.VARCHAR) {
            return resultSetRow.getString(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.TINYINT) {
            return resultSetRow.getInt(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.SMALLINT) {
            return resultSetRow.getInt(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.DATE) {
            return resultSetRow.getDate(columnId);
        } else if (metaData.getColumnType(columnId) == java.sql.Types.TIMESTAMP) {
            return resultSetRow.getTimestamp(columnId);
        } else {
            return resultSetRow.getObject(columnId);
        }
    }
}
