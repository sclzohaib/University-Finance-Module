import { User } from './user';
import { University } from './university';

export class Department {
	id: number;
    name : string;
    location : string;
    telephone : number;
    extensionNo : number;
    university : University;
    users: Array<User>;
}
