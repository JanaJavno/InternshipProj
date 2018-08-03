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
    <li><input type="checkbox" name="commonBox" class="commonBox"/></li>
    <li>
        <button id="block">Block</button>
    </li>
    <li>
        <button id="unblock">Unblock</button>
    </li>
    <li>
        <button id="delete">Delete</button>
    </li>
</ul>
    <table>
        <tr>
            <th></th>
            <th>State</th>
            <th>User</th>
        </tr>
        <#list users as user>
        <tr>
            <th><input type="checkbox" id="${user.id}" class="checkItem""/></th>
            <th>${user.strState()}</th>
            <th>${user.username}</th>

        </tr>
        <#else>
        No users
        </#list>
    </table>
</@c.page>
<script type="text/javascript">
    var checkBoxCollection = document.getElementsByClassName("checkItem");
    var checkBoxMain = document.getElementsByClassName("commonBox")[0];
    checkBoxMain.addEventListener('change', function () {
        if (this.checked) {
            for (i = 0; i < checkBoxCollection.length; i++) {
                checkBoxCollection[i].checked = true;
            }
        }
        else {
            for (i = 0; i < checkBoxCollection.length; i++) {
                checkBoxCollection[i].checked = false;
            }
        }
    });
    [].slice.call(checkBoxCollection).forEach((item) => item.addEventListener('change', function () {
        if ([].slice.call(checkBoxCollection).every(item => item.checked === true)) {
            checkBoxMain.checked = true;
        }
        else checkBoxMain.checked = false;
    }));
    document.getElementById("block").addEventListener('click', function () {
        let userIndexesToBlock = [].slice.call(checkBoxCollection)
                .filter(item => item.checked === true);

        alert("block!");
    });
    document.getElementById("unblock").addEventListener('click', function () {
        let userIndexesToUnlock = [].slice.call(checkBoxCollection)
                .filter(item => item.checked === true);
        alert("unblock!");
    });
    document.getElementById("delete").addEventListener('click', function () {
        let userIndexesToDelete = [].slice.call(checkBoxCollection)
                .filter(item => item.checked === true);
        userIndexesToDelete = userIndexesToDelete.map(function(item){
            return item.id;
        });
        userIndexesToDelete.forEach(element => {
            fetch('http://localhost:8000/delete/' + element, {
                method: 'GET'
            })
                    .then(response => response.json())
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(error => console.error(error));
        });

        //go to "localhost:8080/delete/1"
    })
</script>