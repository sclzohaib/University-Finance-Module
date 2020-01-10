import { User } from './user';
import { AuthorizeLvl } from './authorizelvl';

export class AuthorizeSignatory {

	id : number;
	name: string;
	user : User;
	authorizeLvl:  AuthorizeLvl ;
}
