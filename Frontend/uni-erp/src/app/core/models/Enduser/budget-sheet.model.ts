import { MajorHead } from '../Purchase/major-head';
import { MinorHead } from '../Purchase/minor-head';

export class BudgetSheet {
	// id: string;
	date: Date;
	budgetAllocation: number;
	uptoDateExp: number;
	billAmount: number;
	totalExp: number;
	balanceAvailable: number;
	overExp: number;
	majorHead: MajorHead;
	minorHead: MinorHead;
	// inspectedBy: ;
	// departmentHead: ;
}