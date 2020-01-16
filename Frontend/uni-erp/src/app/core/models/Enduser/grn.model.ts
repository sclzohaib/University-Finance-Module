import { PurchaseOrder } from './purchase-order.model';

export class GoodsReceivedNotes {
	// id: string;
	grnNo: string;
	purchaseOrder: PurchaseOrder;
	date: Date;
	purchaseDate: Date;
	status: string;
	receivedQuantity: number;
	totalQuantity: number;
	rejectionReason: string;
	receivedBy: string;
}