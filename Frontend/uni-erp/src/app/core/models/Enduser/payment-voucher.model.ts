import { Quotation } from './quotation.model';

export class PaymentVoucher {
	// id: string;
	quotation: Quotation;
	payeeName: string;
	payeeCode: string;
	paymentVoucherNo: string;
	date: Date;
	account_code: string;
	account_description: string;
	available_budget: number;
	amount: number;
}