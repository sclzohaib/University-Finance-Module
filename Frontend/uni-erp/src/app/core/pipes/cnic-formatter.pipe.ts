import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'cnicFormatter'
})
export class CnicFormatterPipe implements PipeTransform {

	transform(value: string): string {
		const temp = value.split('');
		temp.splice(5, 0, '-');
		temp.splice(13, 0, '-');
		return temp.join('');
	}

}
