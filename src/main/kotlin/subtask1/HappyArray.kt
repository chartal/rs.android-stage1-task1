package subtask1

class HappyArray {




    fun converToHappy(sadArray: IntArray): IntArray {


        fun isChanged(testArray: IntArray): Boolean {
            var changed = false
            for (i in 1..testArray.size - 2) {
                if (testArray[i - 1] + testArray[i + 1] < testArray[i]) {
                    changed = true
                }
            }
            return changed
        }


        fun converToHappyInside(sadArray: IntArray): IntArray {

            var list: ArrayList<Int> = ArrayList()
            list.add(sadArray[0])
            for (i in 1..sadArray.size - 2) {
                if (sadArray[i - 1] + sadArray[i + 1] >= sadArray[i]) {

                    list.add(sadArray[i])
                }
            }
            list.add(sadArray[sadArray.size - 1])


            //объявляем наш массив
            var chartalArray = IntArray(list.size)
            //заполняем остальные значения:
            for (i in 0..chartalArray.size - 1) {
                chartalArray[i] = list[i]
            }
            return chartalArray
        }


        var result = converToHappyInside(sadArray)
        while (isChanged(result)) {
            result = converToHappyInside(result)
            println(result.joinToString("  "))
        }

        return result
    }





}
