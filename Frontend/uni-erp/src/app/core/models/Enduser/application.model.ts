import { Quotation } from './quotation.model';
import { BudgetSheet } from './budget-sheet.model';
import { PurchaseOrder } from './purchase-order.model';
import { GoodsReceivedNotes } from './grn.model';
import { CoveringLetter } from './covering-letter.model';
import { Summary } from './summary.model';
import { ExpenditureLedger } from './ledger.model';
import { PaymentVoucher } from './payment-voucher.model';

export class Application {
	// id: string;
	subject: string;
	date: Date;
	status: string;
	associatePerson: string;
	department: string;
	university: string;
	// user: string;
	quotation: Array<Quotation>;
	budgetSheet: BudgetSheet | null;
	purchaseOrder: PurchaseOrder | null;
	grn: GoodsReceivedNotes | null;
	coveringLetter: CoveringLetter | null;
	summary: Summary | null;
	ledger: ExpenditureLedger | null;
	paymentVoucher: PaymentVoucher | null;
}