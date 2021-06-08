package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class mathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne")String numberOne, @PathVariable ("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
		return sum;		
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne")String numberOne, @PathVariable ("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double subtraction = convertDouble(numberOne) - convertDouble(numberTwo);
		return subtraction;		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne")String numberOne, @PathVariable ("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double multiplication = convertDouble(numberOne) * convertDouble(numberTwo);
		return multiplication;		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne")String numberOne, @PathVariable ("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double division = convertDouble(numberOne) / convertDouble(numberTwo);
		return division;		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne")String numberOne, @PathVariable ("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double mean = (convertDouble(numberOne) + convertDouble(numberTwo))/2;
		return mean;		
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number")String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double squareRoot = (Double) Math.sqrt(convertDouble(number));
		return squareRoot;		
	}

	private Double convertDouble(String strNumber) {
		 if(strNumber == null)
			 return 0D;
		 String number = strNumber.replaceAll(",", ".");
		 if(isNumeric(number)) 
				 return Double.parseDouble(number);
		 return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");		
	}

}
