package com.nssaap.forms;

import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public class PensionersForm extends ActionForm {
    private List<Map<String, String>> pensionersData;

    public List<Map<String, String>> getPensionersData() {
        return pensionersData;
    }

    public void setPensionersData(List<Map<String, String>> pensionersData) {
        this.pensionersData = pensionersData;
    }
}
