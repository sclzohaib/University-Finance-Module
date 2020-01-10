import { UserType } from './user-type';
import { Role } from './role';
import { AuthorizeSignatory } from './authorize-signatory';
import { Department } from './department';

export class User {
	id: number;
    name: string;
    email: string;
    password : string;
    status: string;
    address: string;
    contactNo : number;
    department: Department;
    roles: Array<Role>;
    authorizeSignatory: AuthorizeSignatory ;
		userType: UserType;
		token?: string;
}
