package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        val list: ArrayList<Int> = ArrayList()
        for (element in bill) {
            list.add(element)
        }
        list.removeAt(k)
        println(list.joinToString("  "))
        val summa = list.sum() / 2
        val ost = b - summa
        return if (summa == b) "Bon Appetit"
        else ost.toString()


    }
}
