package edu.towson.cosc435.sheikh.tipcalculatoractivity

enum class ConvertType{ ten, twenty, thirty}


fun calculate(input: Double, convertType: ConvertType): Double{

   return when(convertType) {
       ConvertType.ten -> ( (input * .10) + input )
       ConvertType.twenty -> ( (input * .20) + input )
       ConvertType.thirty -> ( (input * .30) + input )
   }

}