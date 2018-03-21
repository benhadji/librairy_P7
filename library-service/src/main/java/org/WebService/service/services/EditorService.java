package org.WebService.service.services;

import org.WebService.model.Editor;
import org.WebService.service.AbstractService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Editor")
public class EditorService extends AbstractService {

    @WebMethod
    public List<Editor> getEditorByName(String name) {
        return getManagerFactory().getEditorManager().getByName(name);
    }

    @WebMethod
    public List<Editor> listEditors() {
        return getManagerFactory().getEditorManager().getAllEditors();
    }

    @WebMethod
    public Editor getEditorById(Integer id) {
        return getManagerFactory().getEditorManager().getByID(id);
    }






}
