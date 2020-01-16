import { Vendor } from './vendor.model';
import { QuotationItem } from './quotation-item.model';

export class Quotation {
	// id: string;
	date: Date;
	termsAndConditions: string;
	vendor: Vendor;
	items: Array<QuotationItem>;
	totalAmount: string;
	isApproved?: boolean = false;
	subject: string;
}