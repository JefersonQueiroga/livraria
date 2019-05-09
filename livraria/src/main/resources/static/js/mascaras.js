$(document).ready(function(){

/* Condicional que verifica se é celular ou telefone fixo*/	
		
	$('#tipoTelefone').on('change',function(){
		
		var texto = $(this).val().length;
		
		if (texto == "9"){
			$('#tipo').html('Telefone Celular com : '+ texto + ' dígitos');
			$('#tipoTelefone').mask('000000000', {placeholder: "_____-____"});
			
		} else if(texto == "8") {
			$('#tipo').html('Telefone Fixo com: '+ texto + ' dígitos');
			$('#tipoTelefone').mask('00000000', {placeholder: "____-____"});
			
		}
	});

	
	
});