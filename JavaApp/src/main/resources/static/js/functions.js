function checkPassword(){
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	
	if(password != confirmPassword){
		passwordResult.innerHTML = "<span style='color:red;'>As senhas não são iguais.</span>";
	}
	else{
		passwordResult.innerHTML = "";
	}
}

function checkEmailAvailability() {
  var email = document.getElementById("email").value;
  
  
  var xhr = new XMLHttpRequest();//Esse objeto é usado para realizar requisições assíncronas ao servidor
  
  
  //Abre uma requisição GET: A requisição é aberta usando o método open do objeto XMLHttpRequest 
  //A URL da requisição é "/verify-email?email=" + email. Isso significa que o endereço de email será 
  //enviada como um parâmetro na URL.
  //O terceiro argumento na chamada do método "open" é um booleano que indica se a requisição é 
  //assíncrona ou não. Se o valor for "true", a requisição será assíncrona, o que significa que o 
  //script continua a executar enquanto aguarda a resposta da requisição. Se o valor for "false", a 
  //requisição será síncrona, o que significa que o script aguarda a resposta antes de continuar a 
  //executar. No meu caso como quero fazer um teste sem recarregar a pagina, é necessario o true.
  xhr.open("GET", "/user/verify-email?email=" + email, true);
  
  //Definindo o comportamento da requisição: O comportamento da requisição é definido usando o evento 
  //onreadystatechange. Esse evento é acionado sempre que o estado da requisição muda.
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
      var response = JSON.parse(xhr.responseText);
      if (response) {
        emailResult.innerHTML = "";
      } else {
        emailResult.innerHTML = "O email já está em uso";
      }
    }
  };
  xhr.send();
}
