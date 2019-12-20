import { AuthorizeSignatory } from './authorize-signatory';

export class AuthorizeLvl {
	id : number;
    lvlNo: number;
    authorizeSignatories: Array<AuthorizeSignatory>;
}
