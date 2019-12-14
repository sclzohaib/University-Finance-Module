import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'commaSpacer'
})
export class CommaSpacerPipe implements PipeTransform {

	transform(value: any): string {
		return value.toString().replace(/,/g, ', ');
	}

}
