import { User } from './user';
import { Permission } from './permission';

export class Role {
	id : number;
    title : string;
    users : Array<User>;
    permissions:Array<Permission> ;
}
