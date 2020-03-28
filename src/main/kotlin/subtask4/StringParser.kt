package subtask4

class StringParser {


    fun getResult(inputString: String): Array<String> {


        val list: ArrayList<String> = ArrayList()

        var input: ArrayList<Char> = ArrayList()

        for (char in inputString.toCharArray()) {
            input.add(char)
        }




        fun indication1(input: ArrayList<Char>): Boolean {
            var indication = false
            for (i in 0..input.size - 1) {
                if (input[i] == '(' || input[i] == ')') {
                    indication = true
                }
            }
            return indication
        }

        fun indication2(input: ArrayList<Char>): Boolean {
            var indication = false
            for (i in 0..input.size - 1) {
                if (input[i] == '[' || input[i] == ']') {
                    indication = true
                }
            }
            return indication
        }

        fun indication3(input: ArrayList<Char>): Boolean {
            var indication = false
            for (i in 0..input.size - 1) {
                if (input[i] == '<' || input[i] == '>') {
                    indication = true
                }
            }
            return indication
        }


        fun getResultInside1(input: ArrayList<Char>): ArrayList<Char> {

            val myString = input.joinToString("")

            var a = 0
            var b = 0
            var flag1 = false
            var flag2 = false
            var flag3 = false








            for (i in myString.indices) {

                if (myString[i] == '(') {

                    a = i
                    flag1 = true

                }

                if (myString[i] == ')' && flag1 == true) {

                    b = i

                }

            }


            val s: String = myString.subSequence(a + 1, b) as String
            println(s)
            list.add(s)
            val result = myString.replaceRange(a, b + 1, "")


            //преобразуем результ в массив символов

            var resultArray: ArrayList<Char> = ArrayList()

            for (char in result.toCharArray()) {
                resultArray.add(char)
            }

            // println(resultArray.joinToString("  "))


            return resultArray

        }


        fun getResultInside2(input: ArrayList<Char>): ArrayList<Char> {

            val myString = input.joinToString("")

            var a = 0
            var b = 0
            var flag1 = false
            var flag2 = false
            var flag3 = false



            for (i in myString.indices) {

                if (myString[i] == '[') {

                    a = i
                    flag1 = true

                }

                if (myString[i] == ']' && flag1 == true) {

                    b = i

                }

            }


            val s: String = myString.subSequence(a + 1, b) as String
            println(s)
            list.add(s)
            val result = myString.replaceRange(a, b + 1, "")


            //преобразуем результ в массив символов

            var resultArray: ArrayList<Char> = ArrayList()

            for (char in result.toCharArray()) {
                resultArray.add(char)
            }

            // println(resultArray.joinToString("  "))


            return resultArray


        }


        fun getResultInside3(input: ArrayList<Char>): ArrayList<Char> {

            val myString = input.joinToString("")

            var a = 0
            var b = 0
            var flag1 = false
            var flag2 = false
            var flag3 = false



            for (i in myString.indices) {

                if (myString[i] == '<') {

                    a = i
                    flag1 = true

                }

                if (myString[i] == '>' && flag1 == true) {

                    b = i

                }

            }


            val s: String = myString.subSequence(a + 1, b) as String
            println(s)
            list.add(s)
            val result = myString.replaceRange(a, b + 1, "")


            //преобразуем результ в массив символов

            var resultArray: ArrayList<Char> = ArrayList()

            for (char in result.toCharArray()) {
                resultArray.add(char)
            }

            // println(resultArray.joinToString("  "))


            return resultArray


        }


        var testArray1 = getResultInside1(input)
        //println(testArray.joinToString(""))
        while (indication1(testArray1)) {
            testArray1 = getResultInside1(testArray1)

        }

        var testArray2 = getResultInside2(input)
        //println(testArray.joinToString(""))
        while (indication2(testArray2)) {
            testArray2 = getResultInside2(testArray2)

        }


        var testArray3 = getResultInside3(input)
        //println(testArray.joinToString(""))
        while (indication3(testArray3)) {
            testArray3 = getResultInside3(testArray3)

        }


        var exitArray: Array<String> = list.toTypedArray()
        println("Вот мой массив:" + exitArray.joinToString (" "))


        return exitArray


    }





}
