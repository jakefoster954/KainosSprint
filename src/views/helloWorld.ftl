<#include "/templates/baseLayout.ftl">

<#macro pageContent>
    <table class="table">
        <tr class="tableHeader">
            <th>ID</th>
            <th>Job Name</th>
            <th>Job Spec</th>
        </tr>
        <#foreach job in dto>
        <tr class="tableBody">
            <td>${job.getJobID()}</td>
            <td>${job.getJobName()}</td>
            <td>${job.getJobSpec()}</td>
        </tr>
        </#foreach>
    </table>
</#macro>

