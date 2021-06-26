document.querySelector("#addVerzameling").addEventListener("click", function(){
    var formData = new FormData(document.querySelector("#addVerzamelingForm"));
    var encData = new URLSearchParams(formData.entries());

    fetch("/restservices/verzameling", {method:"PUT", body: encData})
        .then(response => Promise.all([response.status, response.json()]))
        .then(function ([status, myJson]) {
            if (status == 200) {
                alert(myJson)
                alert("Verzameling toegevoegd")
            } else {
                console.log("status was " + status)
            }
        }).catch(error => console.log(error.message));
});