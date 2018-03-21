package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.Editor;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class EditorRM implements RowMapper<Editor> {

    @Override
    public Editor mapRow(ResultSet resultSet, int i) throws SQLException {

        Editor editor = new Editor();

        editor.setId(resultSet.getInt("id"));
        editor.setName(resultSet.getString("name"));

        return editor;
    }
}
