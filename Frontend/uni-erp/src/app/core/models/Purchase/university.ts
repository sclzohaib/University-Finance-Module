import { Department } from '../department.model';

export class University {
	id: number;
    name : string;
    location : string;
    departments: Array<Department>; 
}
