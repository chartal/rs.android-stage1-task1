package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {


        var list: ArrayList<Int> = ArrayList()
        for (char in digitString.toCharArray()) {
            list.add(char.toInt()- '0'.toInt())
        }

        val listLeft: ArrayList<Int> = ArrayList()
        val listRight: ArrayList<Int> = ArrayList()


        for(i in 0..list.size-1){
            if(i<list.size/2){listLeft.add(list[i])}
            else{listRight.add(list[i])}
        }
        listRight.reverse()


        fun getIndication(): Int {
            var indication = 0
            for(i in 0 until listLeft.size) {
                if(listLeft[i] != listRight[i]) {

                    indication++
                    println("Элементы $i не равны, поэтому увеличение indication = $indication")

                }
            }
            return indication
        }
        val t = getIndication()










        //обработка ситуации когда требуемое количество ротаций равно разрешенному
        if(t == k) {


            for(i in 0 until listLeft.size) {

                if (listLeft[i] != listRight[i]) {
                    if (listLeft[i] > listRight[i]) {
                        listRight[i] = listLeft[i]
                    }
                    if (listLeft[i] < listRight[i]) {
                        listLeft[i] = listRight[i]
                    }

                }
            }
        }


        //обработка ситуации когда разрешенное количество ротаций
        //больше требуемого: есть возможность добавления девяток в весомые разряды
        if(t < k) {

            for(i in 1 until listLeft.size) {

                if (listLeft[i] != listRight[i]) {
                    if (listLeft[i] > listRight[i]) {
                        listRight[i] = listLeft[i]
                    }
                    if (listLeft[i] < listRight[i]) {
                        listLeft[i] = listRight[i]
                    }

                }
            }
            listLeft[0]  =  9
            listRight[0] =  9





        }




















        println(list.joinToString (" "))

        val listRight2 = listRight
        listRight2.reverse()




        val result = (listLeft + listRight2).joinToString("")

        println("Требуемое  количество  ротаций: " + t.toString())
        println("Разрешенное количество ротаций: " + k.toString())
        println("Результат: $result")


        if( t > k ){return "-1"} else

            return result


    }




}
