package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {


        var list: ArrayList<Int> = ArrayList()
        for (i in 0..input.size - 1) {
            list.add(input[i])
        }


        var sumList: ArrayList<Int> = ArrayList()
        for (i in 0..list.size - 1) {
            var testList: ArrayList<Int> = ArrayList()
            for (k in 0..list.size - 1) {
                testList.add(list[k])
            }
            testList.removeAt(i)
            val summa = testList.sum()
            sumList.add(summa)
            println(testList.joinToString("  ") + "    cумма элементов = $summa")

        }
        println(sumList.joinToString("  "))
        val minValue: Int = sumList.min()!!
        val maxValue: Int = sumList.max()!!

        return intArrayOf(minValue, maxValue)

    }
}
