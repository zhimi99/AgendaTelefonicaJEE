/*
*
*/

function validar() {
	// Variable que usaremos para determinar si el input es valido
	let isValid = false;
	const input = document.forms['validationForm']['cedula'];
	const message = document.getElementById('message');
	input.willValidate = false;
	const maximo = 10;
	const pattern = new RegExp('^[A-Z]+$', 'i');


	if (!input.value) {
		isValid = false;
	} else {
		if (input.value.length == maximo) {
			isValid = true;
		} else {
			isValid = false;
			} 
		}

	if (!input1.value) {
		isValid = false;
	} else {
		if (input.value.length > maximo) {
			isValid = false;
		} else {
			if (!pattern.test(input.value)) {
				isValid = false;
			} else {
				isValid = true;
			}
		}
	}

	if (!isValid) {
		input.style.borderColor = 'salmon';
		message.hidden = false;
	} else {
		input.style.borderColor = 'palegreen';
		message.hidden = true;
	}
	return isValid;
}

function validar1() {
	// Variable que usaremos para determinar si el input es valido
	let isValid = false;
	const input = document.forms['validationForm']['nombre'];
	const message = document.getElementById('message1');
	input.willValidate = false;
	const maximo = 10;
	const pattern = new RegExp('^[A-Z]+$', 'i');


	if (!input1.value) {
		isValid = false;
	} else {
		if (input.value.length > maximo) {
			isValid = false;
		} else {
			if (!pattern.test(input.value)) {
				isValid = false;
			} else {
				isValid = true;
			}
		}
	}

	if (!isValid) {
		input.style.borderColor = 'salmon';
		message.hidden = false;
	} else {
		input.style.borderColor = 'palegreen';
		message.hidden = true;
	}
	return isValid;
}
 
 
 