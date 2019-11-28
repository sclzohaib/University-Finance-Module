export class FeeType {
	/** Short description of what fee is about. */
	feetype: string;
	/** Revenue Head Code for Fee payment. */
	revenueHead: string;
	/** List of Student for which fee is applicable. */
	studentTypes: Array<string>;
	/** List of Classes for which fee is applicable. */
	classes: Array<string>;
	/** List of Parts for which fee is applicable. */
	parts: Array<string>;
	/** Fee Amount */
	amount: number;
}