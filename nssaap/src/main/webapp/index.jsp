<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
    <title>Pensioners Data</title>
</head>
<body>
    <h2>Pensioners Transactions Last Update Details</h2>
    <table border="1">
        <tr>
            <th>State Code</th>
            <th>State Name</th>
            <th>Last Update Date (DPS)</th>
            <th>Last Update Date (OAPS)</th>
            <th>Last Update Date (WPS)</th>
        </tr>
        <logic:iterate id="row" name="pensionersForm" property="pensionersData">
            <tr>
                <td><bean:write name="row" property="state_code"/></td>
                <td><bean:write name="row" property="state_name"/></td>
                <td><bean:write name="row" property="igndps_pensioner_last_update_date"/></td>
                <td><bean:write name="row" property="ignoaps_pensioner_last_update_date"/></td>
                <td><bean:write name="row" property="ignwps_pensioner_last_update_date"/></td>
            </tr>
        </logic:iterate>
    </table>
</body>
</html>
