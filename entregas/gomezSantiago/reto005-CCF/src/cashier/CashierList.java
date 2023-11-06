package cashier;


public class CashierList {
    private int size = 0;
    private CashierNode first = null;

    public int size(){
        return this.size;
    }

    public void addCashier(String cashierName){
        CashierNode newCashier = new CashierNode(cashierName, true, 0);

        if (this.first == null){
            this.first = newCashier;
        } else {
            CashierNode iterator = this.first;
            while (iterator.getNext() != null){
                iterator = iterator.getNext();
            }
            iterator.setNext(newCashier);
        }
        this.size++;
    }

    public String[] getListCashiers(){
        String[] list = new String[this.size];
        CashierNode iterator = this.first;
        int count = 0;

        while (iterator != null){
            list[count] = iterator.getCashierName();
            if (iterator.getShippingItems() > 0){
                iterator.setShippingItems(iterator.getShippingItems() - 1);
            }
            if (iterator.getShippingItems() == 0) {
                iterator.setAvailable(true);
            }
            System.out.print(iterator.getCashierName() + "[" + iterator.getShippingItems() + "] | ");
            count++;
            iterator = iterator.getNext();
        }
        System.out.println();
        return list;
    }



    public boolean getFreeCashier(){
        CashierNode iterator = this.first;

        while (iterator != null){
            if(iterator.getAvailable() != false){
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }

    public void setServeClient(int item){
        CashierNode iterator = this.first;

        while (iterator != null){
            if(iterator.getAvailable() == true){
                iterator.setShippingItems(item);
                iterator.setAvailable(false);
                break;
            }
            iterator = iterator.getNext();
        }
    }


}