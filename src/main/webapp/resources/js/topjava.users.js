function enable(check, id) {
    var enabled = check.is(":checked");
    $.ajax({
        url: "admin/users/" + id,
        type: "POST",
        data: "enabled=" + enabled
    }).done(function () {
        successNoty(enabled ? "Enable" : "Disable");
        check.closest("tr").attr("Enabled", enabled);
    }).fail(function () {
        check.closest("tr").attr("Enabled", !enabled);
    });
}

// $(document).ready(function () {
$(function () {
    makeEditable({
            ajaxUrl: "admin/users/",
            datatableApi: $("#datatable").DataTable({
                "paging": false,
                "info": true,
                "columns": [
                    {
                        "data": "name"
                    },
                    {
                        "data": "email"
                    },
                    {
                        "data": "roles"
                    },
                    {
                        "data": "enabled"
                    },
                    {
                        "data": "registered"
                    },
                    {
                        "defaultContent": "Edit",
                        "orderable": false
                    },
                    {
                        "defaultContent": "Delete",
                        "orderable": false
                    }
                ],
                "order": [
                    [
                        0,
                        "asc"
                    ]
                ]
            })
        }
    );
});