 function performAjaxSubmit() {
                var sampleFile = document.getElementById("file").files[0];
                var formdata = new FormData();
                formdata.append("file", sampleFile);
                var xhr = new XMLHttpRequest();
                xhr.open("POST","uploadFile.jsp", true);
                xhr.send(formdata);
                xhr.onload = function(e) {
                    if (this.status == 200) {
                       document.getElementById("doc").innerHTML=this.responseText;
                    }
                };
            }
