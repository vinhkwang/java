package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Billboard;


public class BillboardList {
     List<Billboard> billboardList;
     public BillboardList() {
		 this.billboardList = new ArrayList<>();
	 }
     public void add(Billboard newBillBoard) {
    	 billboardList.add(newBillBoard);
     }
     
     public void delete(Billboard newBillBoard) {
    	 billboardList.remove(newBillBoard);
     }
     public void edit(Billboard indexBillboard, Billboard editedBillBoard) {
    	 int indx = billboardList.indexOf(indexBillboard);
    	 billboardList.remove(indexBillboard);
    	 billboardList.add(indx, editedBillBoard);
     }

	public List<Billboard> getBb() {
		return billboardList;
	}

	public void setBb(List<Billboard> bb) {
		this.billboardList = bb;
	}
}
