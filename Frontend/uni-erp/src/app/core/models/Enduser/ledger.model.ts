import { MinorHead } from '../Purchase/minor-head';

export class ExpenditureLedger {
	// id: string;
	particulars: string;
	debitAmount: number;
	uptoDateExpenditure: number;
	balance: number;
	date: Date;
	minorHead: MinorHead;
}