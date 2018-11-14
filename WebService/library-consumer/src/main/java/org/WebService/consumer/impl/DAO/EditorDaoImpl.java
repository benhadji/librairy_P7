package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.EditorDAO;
import org.WebService.consumer.impl.RowMapper.EditorRM;
import org.WebService.model.Editor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import java.sql.Types;
import java.util.List;

public class EditorDaoImpl extends AbstractDaoImpl implements EditorDAO {

    @Inject
    private EditorRM editorRM;

    public EditorRM getEditorRM() {
        return editorRM;
    }

    public void setEditorRM(EditorRM editorRM) {
        this.editorRM = editorRM;
    }

    @Override
    public void create(Editor editor) {

        String vSQL = "INSERT INTO public.editor (name) VALUES(:name)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("name", editor.getName(), Types.VARCHAR);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);



    }


    @Override
    public List<Editor> getAllEditors() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM editor";

        List<Editor> vList = vJdbcTemplate.query(sql,editorRM);
        return vList;

    }

    @Override
    public List<Editor> getByName(String name) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String var = "'"+name+"'";
        String vSQL = "SELECT * FROM editor WHERE name = "+var;

        try {
            List<Editor> editors = vJdbcTemplate.query(vSQL,editorRM);
            return editors;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }

    @Override
    public Editor getById(Integer id) {
        String vSQL = "SELECT * FROM public.editor WHERE id=:id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Editor editor = vJdbcTemplate.queryForObject(vSQL, vParams, editorRM);
            return editor;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }

    }

    @Override
    public Editor getByBookTitle(String title) {
        String vSQL = "select * from public.editor join book b on editor.id = b.editor_id " +
                "where b.title = :title";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("title", title);
        try {
            Editor editor = vJdbcTemplate.queryForObject(vSQL, vParams, editorRM);
            return editor;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


}
