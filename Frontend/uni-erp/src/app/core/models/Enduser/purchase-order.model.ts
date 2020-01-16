import { Quotation } from './quotation.model';

export class PurchaseOrder {
	// id: string;
	date: Date;
	quotation: Quotation;
	purchaseOrderNo: string;
}