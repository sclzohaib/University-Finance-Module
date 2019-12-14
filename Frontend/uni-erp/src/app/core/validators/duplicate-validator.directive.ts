import { ValidatorFn, AbstractControl } from '@angular/forms';

export function duplicateValidator(collection: Array<string>): ValidatorFn {
	return (control: AbstractControl): { [key: string]: any } | null => {
		const forbidden = collection.find(item => {
			return item.toLowerCase() === (<string>control.value).toLowerCase();
		});
		return forbidden ? { 'duplicate': { value: control.value } } : null;
	};
}