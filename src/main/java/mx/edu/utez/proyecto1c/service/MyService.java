package mx.edu.utez.proyecto1c.service;

import mx.edu.utez.proyecto1c.EXCEPTION.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1c.dto.RequestCalculadoraDTO;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;

///para q se vea una clase de servicio
@Service
public class MyService {

    public double calculadora(RequestCalculadoraDTO payload) {

        double resultado=0;

        ///en caaso de no ser una op valida lanzar:
        //una ecepsion que corta el flujo
   if(payload.getOperacion().equals("DIVISION")
   || !payload.getOperacion().equals("SUMA") &&
           !payload.getOperacion().equals("RESTA")    &&
           !payload.getOperacion().equals("MULTIPLICACION")){

       ////LAZAR LA EXCEPSION
            throw new BadRequestException("la op no es validaaaaa");
   }



        switch(payload.getOperacion()){
            case "MULTIPLICACION":
                resultado= payload.getNum1() * payload.getNum2();
                break;
            case "SUMA":
                resultado= payload.getNum1()+ payload.getNum2();
                break;
            case    "RESTA":
                resultado= payload.getNum1()- payload.getNum2();
                break;
            case "DIVISION":
                resultado= payload.getNum1()/ payload.getNum2();
                break;
        }
        return resultado;
    }
}
