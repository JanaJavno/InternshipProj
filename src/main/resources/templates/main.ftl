<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>
    <@l.logout/>
    <div>User list</div>
<ul>
    <li><a href="/blockUser">Block</a></li>
    <li><a href="/unblockUser">Unblock</a></li>
    <li><a href="/deleteUser">Delete</a></li>
</ul>
    <table>
        <tr>
            <th></th>
            <th>State</th>
            <th>User</th>
        </tr>
        <#list users as user>
        <tr>
            <th><input type="checkbox" id="checkbox"/></th>
            <th>state</th>
            <th>${user.username}</th>
        <#--<th>${user.state}</th>-->
        </tr>
        <#else>
        No users
        </#list>
    </table>
</@c.page>