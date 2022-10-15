//const BASE_URL = 'Http://140.238.187.28:8080'
const BASE_URL = 'http://localhost:8080'
function guardarInformacionCategory(){

    $("#resultadoCategory").empty();
    let myData ={name:$("#nameCategory").val(),description:$("#descripcionCategory").val(),}
    let dataToSend = JSON.stringify(myData);
    $.ajax ({
        url: BASE_URL +'/api/Category/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        console.log(respuesta);
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}

function traerInformacionCategory(){
    $.ajax({
            url: BASE_URL +'/api/Category/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaCategory(respuesta);           
            }                     
        }      
    );
}

function pintarRespuestaCategory(items){

    $("#resultadoCategory").empty();
    let myTable="<table border=3>";
    myTable += "<tr><th>Id</th><th>Name</th><th>Description</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].id+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].description+"</td>";                             
        myTable+="<td><button onclick='borrarCategory("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='actualizarCategory("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultadoCategory").append(myTable);

}

function actualizarCategory(idElemento){

    $("#resultado").empty();

    let myData ={id:idElemento, name:$("#nombreCategory").val(),description:$("#descripcionCategory").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
            url: BASE_URL + '/api/Category/update',
            type: 'PUT',
            data: dataToSend,
            datatype: "JSON",
            contentType: 'application/json',
            success:function(respuesta){
            alert("Actualizacion exitosa");
            },
            error:function(xhr,status){
            alert('Operacion no satisfactoria,'+ xhr.status );
                }
        }
    );
}

function borrarCategory(idElemento){
    
    $.ajax ({
            url: BASE_URL + '/api/Category/' + idElemento,
            type: 'DELETE',
            datatype: "JSON",
            success: function(respuesta){
            // console.log(respuesta);
            alert("Borrado exitoso");
            },
            error:function(xhr,status){                                
            alert('Operacion no satisfactoria,'+ xhr.status );
                }
        }
    );
}

/*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°Skate°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*/
function traerInformacionSkate(){
    $.ajax({
            url: BASE_URL +'/api/Skate/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaSkate(respuesta);           
            }                    
            }  
        );
}

function pintarRespuestaSkate(items){

    $("#resultadoSkate").empty();

    let myTable="<table border=3>";
   myTable += "<tr><th>Id</th><th>Name</th> <th>Brand</th><th>Year_b</th><th>Description</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].id+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].brand+"</td>";
       myTable+="<td>"+items[i].year+"</td>";
       myTable+="<td>"+items[i].description+"</td>";                
       myTable+="<td>"+items[i].category.id +"</td>";                
       myTable+="<td>"+items[i].category.name +"</td>";                
       myTable+="<td>"+items[i].category.description +"</td>";                
       myTable+="<td>"+items[i].message +"</td>";                        
       myTable+="<td>"+items[i].reservation+"</td>";                
       myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='borrarSkate("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='actualizarSkate("+items[i].id+")'>Actualizar</button>";
       //myTable+="<td><button onclick='borrarSkate("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='actualizarSkate("+items[i].id+")'>Actualizar</button>";

       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoSkate").append(myTable);
}

function guardarInformacionSkate(){

    $("#resultadoSkate").empty();
    let myData ={brand:$("#brandSkate").val(),year_b:$("#year_bSkate").val(),name:$("#nameSkate").val(),description:$("#descripcionSkate").val(),}
    let dataToSend = JSON.stringify(myData);
    $.ajax ({
        url: BASE_URL +'/api/Skate/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        console.log(respuesta);
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}

function actualizarSkate(idElemento){

    $("#resultado").empty();

    let myData ={id:idElemento, brand:$("#brandSkate").val(),name:$("#nameSkate").val(),description:$("#descripcionSkate").val(),year:("#yearSkate")}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL + '/api/Skate/update',
        type: 'PUT',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success:  function(respuesta){
        //console.log(respuesta);
        alert("Actualizacion exitosa");
        },
        error:function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
        }

        }
    );
}

function borrarSkate(idElemento){
    
    $.ajax ({
        url: BASE_URL + '/api/>Skate/' + idElemento,
        type: 'DELETE',
        datatype:  "JSON",
        success:  function(respuesta){
         // console.log(respuesta);
        alert("Borrado exitoso");
        },
        error: function(xhr,status){                                
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}

/*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°Client°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*/

function traerInformacionClient(){

    $.ajax({
            url: BASE_URL +'/api/Client/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaClient(respuesta); 
                         
            }
                                 
            }
               
        );
}

function pintarRespuestaClient(items){

    $("#resultadoClient").empty();

    let myTable="<table border=3>";
   myTable += "<tr><th>IdClient</th><th>Email</th><th>Password</th><th>Name</th><th>Age</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idClient+"</td>";
       myTable+="<td>"+items[i].email+"</td>";
       myTable+="<td>"+items[i].password+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].age+"</td>";                
       //myTable+="<td>"+items[i].category.id +"</td>";                
       //myTable+="<td>"+items[i].category.name +"</td>";                
       //myTable+="<td>"+items[i].category.description +"</td>";                
       myTable+="<td>"+items[i].message +"</td>";                        
       myTable+="<td>"+items[i].reservation+"</td>";                
       myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='borrarClient("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='actualizarClient("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoClient").append(myTable);
}

function guardarInformacionClient(){

    $("#resultadoClient").empty();
    let myData ={email:$("#emailClient").val(),password:$("#passwordClient").val(),name:$("#nameClient").val(),age:$("#ageClient").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL +'/api/Client/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        console.log(respuesta);
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}


function actualizarclient(idElemento){

    $("#resultado").empty();

    let myData ={id:idElemento, name:$("#namelClient").val(),email:$("#emailClient").val(),password:$("#passworClient").val(),age:$("#ageClient").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL + '/api/Client/update',
        type: 'PUT',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success:  function(respuesta){
        //console.log(respuesta);
        alert("Actualizacion exitosa");
        },
        error:function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
        }

        }
    );
}

function borrarClient(idElemento){
    
    $.ajax ({
        url: BASE_URL + '/api/Client/' + idElemento,
        type: 'DELETE',
        datatype:  "JSON",
        success:  function(respuesta){
         // console.log(respuesta);
        alert("Borrado exitoso");
        },
        error: function(xhr,status){                                
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}


/*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°|Message°°°°°°°°°°°°°°°°*/

function traerInformacionMessage(){
    $.ajax({
            url: BASE_URL +'/api/Message/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaMessage(respuesta); 
                         
            }
                                 
        }
               
    );
}

function pintarRespuestaMessage(items){

    $("#resultadoMessage").empty();

    let myTable="<table border=3>";
    myTable += "<tr><th>IdMessage</th><th>MessageText</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idMessage+"</td>";
       myTable+="<td>"+items[i].messageText+"</td>";                          
       //myTable+="<td><button onclick='borrarMessage("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='actualizarMessage("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoMessage").append(myTable);

}
function guardarInformacionMessage(){

    $("#resultadoMessage").empty();
    let myData ={messageText:$("#messageText").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL +'/api/Message/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}


/*
function actualizarMessage(idElemento){

    $("#resultado").empty();

    let myData ={id:idElemento, messageText:$("#messageText").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL + '/api/Message/update',
        type: 'PUT',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success:  function(respuesta){
        //console.log(respuesta);
        alert("Actualizacion exitosa");
        },
        error:function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
        }

        }
    );
}

function borrarMesage(idElemento){
    
    $.ajax ({
        url: BASE_URL + '/api/Message/' + idElemento,
        type: 'DELETE',
        datatype:  "JSON",
        success:  function(respuesta){
         // console.log(respuesta);
        alert("Borrado exitoso");
        },
        error: function(xhr,status){                                
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}
*/

/*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°Reservation°°°°°°°°°°°°°°°°°°°°°°*/

function traerInformacionReservation(){
    $.ajax({
            url: BASE_URL +'/api/Reservation/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaReservation(respuesta); 
                         
            }
                                 
        }
               
    );
}

function pintarRespuestaReservation(items){

    $("#resultadoReservation").empty();

    let myTable="<table border=3>";
    myTable += "<tr><th>IdReservation</th><th>StartDate</th><th>DevolutionDate</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idReservation+"</td>";
       myTable+="<td>"+items[i].startDate+"</td>";   
       myTable+="<td>"+items[i].devolutionDate+"</td>";                   
        myTable+="<td><button onclick='borrarCategory("+items[i].id+")'>Borrar</button>";
       myTable+="<td><button onclick='actualizarCategory("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoReservation").append(myTable);

}
function guardarInformacionReservation(){

    $("#resultadoReservation").empty();
    let myData ={startDate:$("#startDate").val(),devolutionDate:$("#devolutionDate").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL +'/api/Reservation/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        console.log(respuesta);
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}

/*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° Consult TOP Clients °°°°°°°°°°°°°°°°°°°°°°*/

