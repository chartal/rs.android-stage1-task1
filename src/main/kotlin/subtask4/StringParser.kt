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
            var flag1 = false
            var flag2 = false

            for (i in 0..input.size - 1) {

                if (input[i] == '(') {
                    flag1 = true
                }

                if (input[i] == ')') {
                    flag2 = true
                }

            }
            if (flag1 && flag2) {
                indication = true
            }

            return indication
        }


        fun indication2(input: ArrayList<Char>): Boolean {
            var indication = false
            var flag1 = false
            var flag2 = false

            for (i in 0..input.size - 1) {

                if (input[i] == '[') {
                    flag1 = true
                }

                if (input[i] == ']') {
                    flag2 = true
                }

            }
            if (flag1 && flag2) {
                indication = true
            }

            return indication
        }


        fun indication3(input: ArrayList<Char>): Boolean {
            var indication = false
            var flag1 = false
            var flag2 = false

            for (i in 0..input.size - 1) {

                if (input[i] == '<') {
                    flag1 = true
                }

                if (input[i] == '>') {
                    flag2 = true
                }

            }
            if (flag1 && flag2) {
                indication = true
            }

            return indication
        }
        fun getFirstFornit(input: ArrayList<Char>): Int {

            var flag1 = false
            var flag2 = false
            var flag3 = false

            for (i in 0..input.size - 1) {

                if ((input[i] == '(') && (flag2==false) && (flag3==false) && indication1(input)) {
                    flag1 = true
                }

                if ((input[i] == '[') && (flag1==false) && (flag3==false) && indication2(input)) {
                    flag2 = true
                }

                if ((input[i] == '<') && (flag1==false) && (flag2==false) && indication3(input) ) {
                    flag3 = true
                }
            }


            if (flag1) return 0
            if (flag2) return 1
            if (flag3) return 2

            else return 5

        }







        fun indication(input: ArrayList<Char>): Boolean {

            return (indication1(input) || indication2(input) || indication3(input))


        }

























        fun getResultInside(input: ArrayList<Char>): ArrayList<Char> {

            val myString = input.joinToString("")

            var a = 0
            var b = 0
            var flag1 = false
            var flag2 = false


            var arrayLeft: ArrayList<Char> = ArrayList()
            var arrayCenter: ArrayList<Char> = ArrayList()
            var arrayRight: ArrayList<Char> = ArrayList()


            //определение порядка парсинга строки

            var start: Char = '('
            var end: Char = ')'

            val fornit = getFirstFornit(input)
            if (fornit == 0) {
                start = '('
                end = ')'
            }

            if (fornit == 1) {
                start = '['
                end = ']'
            }

            if (fornit == 2) {
                start = '<'
                end = '>'
            }


            //блок поиска части строки, заключенной в скобки

            for (i in 0 until input.size) {

                if ((input[i] == start) && !flag1) {
                    flag1 = true
                    a = i

                }

                if ((input[i] == end) && flag1 && !flag2) {
                    b = i
                    flag2 = true
                }
            }


            //блок записи в массивы
            for (i in 0 until input.size) {
                if (i < a) {
                    arrayLeft.add(input[i])
                }
                if ((a < i) && (i < b)) {
                    arrayCenter.add(input[i])
                }
                if (i > b) {
                    arrayRight.add(input[i])
                }

            }




            val s = arrayCenter.joinToString("")
            list.add(s)


            while (indication(arrayCenter)) {
                arrayCenter = getResultInside(arrayCenter)

            }




            val result = (arrayLeft + arrayRight) as ArrayList<Char>
            return result

        }


        //поиск строк внутри круглых скобок


        while (indication(input)) {
            input = getResultInside(input)

        }


        var exitArray: Array<String> = list.toTypedArray()
        //exitArray.reverse()


        println("Вот исходная строка: " + inputString)
        println("Вот мой массив: " + exitArray.joinToString("  "))

        return exitArray


    }


}

